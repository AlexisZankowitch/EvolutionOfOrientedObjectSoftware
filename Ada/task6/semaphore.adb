with Text_IO;
use Text_IO;

procedure semaphore is

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

   	task type Printing (First : Integer);
	task type Semaphore is 
		entry p;
		entry v;
	end Semaphore;
	type DynPrinting is access Printing;
   	
	Even, Odd : DynPrinting;
	Sem1 : Semaphore;

	procedure PrintRow(N : in Integer; M : in Matr) is
	begin
		Put("Row");
		Put(Integer'Image(N));
		Put(". Elements:");
     	for i in M'Range(2) loop
  	 		Put(Integer'Image(M(N,i)));
			Delay 0.0;
     	end loop;		
		New_Line;
	end PrintRow;

	task body Semaphore is 
	begin 
		loop
			accept p;
			accept v;
		end loop;
	end Semaphore;

   	task body Printing is
	  	iE : Integer := First;
	begin
	  	while (iE <= M'Last) loop
			Sem1.p;
			PrintRow(iE,M);
			Sem1.v;
			iE := iE + 2;
  		end loop;
   	end Printing ;

begin
	Odd := new Printing(M'First);
	Even := new Printing(M'First+1);
end semaphore;



