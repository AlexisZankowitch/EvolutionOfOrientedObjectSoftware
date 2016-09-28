package Sq_Pack is
   type Square is tagged private;
   procedure Init(Sq : out Square;
   A : in Integer);

   function GetPerimeter(Sq : in Square)
      return Integer;

   function GetArea(Sq : in Square)
      return Integer;

   procedure Print(Sq : in Square);

   private
      type Square is tagged record
         A : Integer;
      end record;
end Sq_Pack;