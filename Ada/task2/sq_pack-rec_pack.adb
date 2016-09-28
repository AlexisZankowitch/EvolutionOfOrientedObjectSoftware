with Text_IO, Ada.Integer_Text_IO;
use Text_IO, Ada.Integer_Text_IO;

package body Sq_Pack.Rec_Pack is
   procedure Init(Rec : out Rectangle;
   A,B : in Integer) is
   begin
      Rec.A := A;
      rec.B := B;
   end Init;

   function getPerimeter(Rec: in Rectangle)
      return Integer is
   begin
      return 2*(Rec.A+Rec.B);
   end getPerimeter;

   function getArea(Rec: in Rectangle)
      return Integer is
   begin
      return REc.A*Rec.B;
   end getArea;

   procedure Print(Rec: in Rectangle) is
   begin
      Put("A: ");Put(Rec.A, 1);
      Put(" B: ");Put(Rec.B, 1);
      Put(" Perimeter: ");Put(Rec.getPerimeter, 1);
      Put(" Area: ");Put(Rec.getArea, 1);
      New_Line;
   end Print;

end Sq_Pack.Rec_Pack;
