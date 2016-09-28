with Sq_Pack, Sq_Pack.rec_pack;
use Sq_pack, Sq_Pack.rec_pack;

procedure Main is
   Sq : Square;
   Rec : Rectangle;

   begin
      Init(Sq,7);
      Init(Rec,2,8);
      Print(Sq);
      Print(Rec);
end Main;