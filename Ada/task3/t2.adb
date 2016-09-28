with Text_IO;
use Text_IO;

procedure T2 is
   type Matr is array (Integer range <>, Integer range <>) of Integer;
   M : Matr(1..7,1..5) := (
      (1,2,3,4,5),
      (6,7,8,9,10),
      (11,12,13,14,15),
      (16,17,18,19,20),
      (21,22,23,24,25),
      (26,27,28,29,30),
      (31,32,33,34,35)
   );


   task type Sum (First, D1,D2 : Integer);

   task body Sum is
      iE : Integer := First;
      c : Integer;
   begin
      while (iE <= M'Last) loop
      c := 0;
         for i in M'Range(2) loop
            c := c + M(iE,i);
         end loop;
      Put_line("Sum of elements in row" & Integer'Image(iE) & Integer'Image(c));
      iE := iE + 2;
      delay Duration(D1)/Duration(D2);
      end loop;
   end Sum ;

   Odd : Sum(1,1,2);
   Even : Sum(2,2,3);


begin
   null;
end T2;


