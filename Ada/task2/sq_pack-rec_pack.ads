package Sq_Pack.Rec_Pack is
   type Rectangle is new Sq_Pack.Square
      with private;

   procedure Init(Rec : out Rectangle;
   A,B : in Integer);

   function GetPerimeter(Rec: in Rectangle)
      return Integer;

   function GetArea(Rec: in Rectangle)
      return Integer;

   procedure Print(Rec: in Rectangle);

   private
      type Rectangle is new Sq_Pack.Square
         with record
            B : Integer;
         end record;
end Sq_Pack.Rec_Pack;