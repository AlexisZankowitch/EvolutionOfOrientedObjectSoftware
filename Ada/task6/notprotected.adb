with Text_IO;
use Text_IO;

procedure notprotected is

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

	procedure PrintRow(N : in Integer; M : in Matr) is
	begin
		Put("Row");
		Put(Integer'Image(N));
		Put(". Elements:");
     	for i in M'Range(2) loop
  	 		Put(Integer'Image(M(N,i)));
			Delay 0.0;
     	end loop;
	end PrintRow;

   	task type Printing (First : Integer);

   	task body Printing is
	  	iE : Integer := First;
	begin
	  	while (iE <= M'Last) loop
			PrintRow(iE,M);
			iE := iE + 2;
			Put_Line(" ");
  		end loop;
   	end Printing ;

   	type DynPrinting is access Printing;
   	Even, Odd : DynPrinting;


begin
	Odd := new Printing(M'First);
	Even := new Printing(M'First+1);
end notprotected;



