with Text_IO, Ada.Integer_Text_IO;
use Text_IO, Ada.Integer_Text_IO;

package body Sq_Pack is
   procedure Init(Sq : out Square;
   A : in Integer) is
   begin
      Sq.A := A;
   end Init;

   function getPerimeter(Sq : in Square)
      return Integer is
   begin
      return Sq.A*4;
   end getPerimeter;

   function getArea(Sq : in Square)
      return Integer is
   begin
      return Sq.A*Sq.A;
   end getArea;

   procedure Print(Sq : in Square) is
   begin
      Put("A: ");Put(Sq.A, 1);
      Put(" Perimeter: ");Put(Sq.getPerimeter, 1);
      Put(" Area: ");Put(Sq.getArea, 1);
      New_Line;
   end Print;

end Sq_Pack;