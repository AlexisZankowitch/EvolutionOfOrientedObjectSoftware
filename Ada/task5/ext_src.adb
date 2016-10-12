with Text_IO;
use  Text_IO;

procedure ext_src is
   
   task MaxElementInRow is
      entry TotalRequests(N : in integer);
      entry Row(R : in integer);
   end MaxElementInRow;
   
   task ListOfRows is
      entry Result(Max : in Integer);
   end ListOfRows;

   task body MaxElementInRow is
      N : constant Integer := 6;
      M : constant Integer := 5;
      type Matrix is array(1..N, 1..M) of Integer;
      Matr : Matrix := (
         (0, 0, 10, 0, 0),
         (1, 20, 1, 1, 1),
         (1, 2, 30, 2, 1),
         (40, 1, 2, 3, 1),
         (1, 50, 4, 1, 2),
         (1, 2, 60, 5, 4)
      );  

      RNum    : Integer;
      Max     : Integer;
      Total   : Integer;
      Counter : Integer := 0;
	c : Integer;
   begin
      delay 0.1;
	  c := 0;
      accept TotalRequests(N: in Integer) do
         Total := N;
      end TotalRequests;
      while (Counter < Total) loop
	     select
			accept Row(R : in integer) do
			RNum := R;
			end Row;
			Max := Matr(RNum, Matr'First(2)); 
			for j in Matr'Range(2) loop
			if (Matr(RNum, j) > Max) then
			   Max := Matr(RNum, j);
			end if;
			end loop;
			Put_line("Task 'MaxElementInRow': waiting in 'Row' =" & Integer'Image(c));		
			ListOfRows.Result(Max);
			Counter := Counter + 1;
	     or 
			delay 0.1;	
			c := c+1;
			Put("#");
		 end select;
      end loop;
   end MaxElementInRow;

   task body ListOfRows is
      N : constant Integer := 7;
      type Vector is array(Integer range<>) of Integer;
      V : Vector(1..N) := (2, 3, 6, 1, 5, 1, 4);
      i : Integer := V'First;
      MaxElem : Integer;
	  c : Integer;
   begin
	c := 0;
	loop
		select
			MaxElementInRow.TotalRequests(V'Length);
			exit;
		else
			delay 0.1;
			c := c+1;
			Put("*");
		end select;
	end loop;
	Put_Line("");
    Put_Line("Task 'ListOfRows': TOTAL waiting of entry 'TotalRequests' = " & Integer'Image(c));
      
      while (i <= V'Length) loop
         delay 0.3;
         MaxElementInRow.Row(V(i));
         
         accept Result(Max: in Integer) do
            MaxElem := Max;
         end Result;
         Put_Line("Row:" & Integer'Image(V(i)) & 
            ". Maximal element:" & Integer'Image(MaxElem) & ".");
         i := i+1;
      end loop;
   end ListOfRows;

begin
   null;
end ext_src
;
