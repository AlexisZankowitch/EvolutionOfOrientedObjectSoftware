with Text_IO;
use Text_IO;

procedure pprotected is

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
	type DynPrinting is access Printing;
	protected type Resource is 
		procedure PrintRow(N : in Integer; M : in Matr);
	end Resource;
   	
	Even, Odd : DynPrinting;
	Printer : Resource;

	
	protected body Resource is 
		procedure PrintRow(N : in Integer; M : in Matr) is
		begin
			Put("Row");
			Put(Integer'Image(N));
			Put(". Elements:");
		 	for i in M'Range(2) loop
	  	 		Put(Integer'Image(M(N,i)));
		 	end loop;		
			New_Line;
		end PrintRow;
	end Resource;


   	task body Printing is
	  	iE : Integer := First;
	begin
	  	while (iE <= M'Last) loop
			Printer.PrintRow(iE,M);
			delay 0.5;
			iE := iE + 2;
  		end loop;
   	end Printing ;

begin
	Odd := new Printing(M'First);
	Even := new Printing(M'First+1);
end pprotected;



