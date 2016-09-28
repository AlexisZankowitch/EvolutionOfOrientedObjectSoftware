with Text_IO, Ada.Integer_Text_IO;
use Text_IO, Ada.Integer_Text_IO;

procedure RendezVous is

    type MatR is array (Integer range <>, Integer range <>) of Integer;
       M : MatR(1..7,1..5) := (
          (1,2,3,4,5),
          (6,7,8,9,10),
          (11,12,13,14,15),
          (16,17,18,19,20),
          (21,22,23,24,25),
          (26,27,28,29,30),
          (31,32,33,34,35)
       );

    -- TASK INTERFACE
    task MaxElementInRow is
        entry TotalRows(N : in Integer); -- amount of indexes of rows in vector
        entry Row(i : in Integer); -- index of row
    end MaxElementInRow;

    task ListOfRows is
        entry Result(Max : in Integer); -- calculated maximum
    end ListOfRows;

    --TASK IMPLEMENTATION
    task body MaxElementInRow is
        tRows : Integer;
        r : Integer;
        c : Integer;
        max : Integer;
    begin
        c := 0;
        accept TotalRows (N : in Integer) do
            tRows := N;
        end TotalRows;

        loop
            accept Row (i : in Integer) do
                r := i;
            end Row;
            max := M(r,1);
            for i in M'Range(2) loop
                if (M(r,i) > max) then
                    max := M(r,i);
                end if;
            end loop;
            ListOfRows.Result(max);
            c := c + 1;
            exit when c >= tRows;
        end loop;
    end MaxElementInRow;

    task body ListOfRows is
        res : Integer;
        iRow : Integer;
    begin
        iRow := M'First;
        MaxElementInRow.TotalRows(M'Last);

        loop
            MaxElementInRow.Row(iRow);
            accept Result (Max : in Integer) do
                res := Max;
            end Result;
            Put_line("Row" & Integer'Image(iRow) &  "Maximal element" & Integer'Image(res));
            iRow := iRow + 1;
            exit when iRow > M'Last;
        end loop;

    end ListOfRows;


begin
    null;
end RendezVous;