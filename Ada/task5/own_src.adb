with Text_IO, Ada.Integer_Text_IO;
use Text_IO, Ada.Integer_Text_IO;

procedure own_src is

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
    begin
        c := 0;
        accept TotalRows (N : in Integer) do
            tRows := N;
        end TotalRows;
        while (c < tRows) loop
            select
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
            or
                delay 1.0;
                Put("#");
            end select;
        end loop;
    end MaxElementInRow;

    task body ListOfRows is
        res : Integer;
        iRow : Integer;
        Type Vec is Array (Integer range <>) of Integer;
        v : Vec (1..7) := (2, 3, 6, 1, 5, 1, 4);
    begin
        loop
            select
                MaxElementInRow.TotalRows(v'Length);
                Exit;
            else
                Put("*");
            end select;
        end loop;
        iRow := v'First;
        while (iRow <= v'Length) loop
            MaxElementInRow.Row(v(iRow));
            accept Result (Max : in Integer) do
                res := Max;
            end Result;
            Put_line("Row" & Integer'Image(v(iRow)) &  " Maximal element" & Integer'Image(res));
            iRow := iRow + 1;
        end loop;

    end ListOfRows;


begin
    null;
end own_src;



