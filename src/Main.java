import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {
        InBean ib = new InBean();
        ib.setTorihikisakiName( "セントラル商会" );
        ib.setTorihikiDate( LocalDate.of( 2018, 5, 2 ) );
        ib.setGoukei( 400 );

        ib.getLines().add( new InLineBean( "消しゴム", 1, 100 ) );
        ib.getLines().add( new InLineBean( "鉛筆", 20, 300 ) );

        OutBean ob = tenki( ib );
        System.out.println( ob.toString() );
    }

    @Override
    public String toString()
    {
        return "Main []";
    }

    /*
     * 無視したもの
     * ・OutBeanの存在について(元々転記先はある前提で手順を作成したため)
     * ・8、9の番号の部分
     */
    static OutBean tenki(InBean ib)
    {
        //転記先は用意してある前提で書いたのでOutBeanを宣言
        OutBean ob = new OutBean();

        //1.日付を読む
        LocalDate dateIb = ib.getTorihikiDate();

        //2.日付を記入
        ob.setTorihikiDate( dateIb );

        //3.取引先を読む
        String torihikisakiNameIb = ib.getTorihikisakiName();

        //4.取引先を記入
        ob.setTorihikisakiName( torihikisakiNameIb );

        do
        {
            //5.5×4の表の外枠の作成
            //6.表の項目名(商品名、数量、金額)を読む
            //7.表の項目名を記入

            //8.番号、商品名、数量、金額を読む
            InLineBean ilb = ib.getLines().remove( 0 );
            String ilbShouhinName = ilb.getShouhinName();
            int ilbKingaku = ilb.getKingaku();
            int ilbSuuryo = ilb.getSuuryo();

            //9.読んだ番号、商品名、数量、金額を表に記入する
            OutLineBean olb = new OutLineBean();
            olb.setShouhinName( ilbShouhinName );
            olb.setKingaku( ilbKingaku );
            olb.setSuuryo( ilbSuuryo );
            ob.getLines().add( olb );

            //10.4行を超える場合は次のページへ行き、5.から行う
        } while (ib.getLines().size() != 0);

        //11.合計金額を読む
        int goukeiIb = ib.getGoukei();

        //12.合計金額を記入
        ob.setGoukei( goukeiIb );

        return ob;

    }

}

//------------------------------------
class InBean
{
    private LocalDate torihikiDate;
    private String torihikisakiName;
    private int goukei;
    private List<InLineBean> lines = new ArrayList<InLineBean>();

    public LocalDate getTorihikiDate()
    {
        return torihikiDate;
    }

    public void setTorihikiDate(LocalDate torihikiDate)
    {
        this.torihikiDate = torihikiDate;
    }

    public String getTorihikisakiName()
    {
        return torihikisakiName;
    }

    public void setTorihikisakiName(String torihikisakiName)
    {
        this.torihikisakiName = torihikisakiName;
    }

    public int getGoukei()
    {
        return goukei;
    }

    public void setGoukei(int goukei)
    {
        this.goukei = goukei;
    }

    public List<InLineBean> getLines()
    {
        return lines;
    }

}

class InLineBean
{
    private String shouhinName;
    private int suuryo;
    private int kingaku;

    public InLineBean(String shouhinName, int suuryo, int kingaku)
    {
        super();
        this.shouhinName = shouhinName;
        this.suuryo = suuryo;
        this.kingaku = kingaku;
    }

    public String getShouhinName()
    {
        return shouhinName;
    }

    public void setShouhinName(String shouhinName)
    {
        this.shouhinName = shouhinName;
    }

    public int getSuuryo()
    {
        return suuryo;
    }

    public void setSuuryo(int suuryo)
    {
        this.suuryo = suuryo;
    }

    public int getKingaku()
    {
        return kingaku;
    }

    public void setKingaku(int kingaku)
    {
        this.kingaku = kingaku;
    }

}

//------------------------------------
class OutBean
{
    private LocalDate torihikiDate;
    private String torihikisakiName;
    private int goukei;
    private List<OutLineBean> lines = new ArrayList<OutLineBean>();

    public LocalDate getTorihikiDate()
    {
        return torihikiDate;
    }

    public void setTorihikiDate(LocalDate torihikiDate)
    {
        this.torihikiDate = torihikiDate;
    }

    public String getTorihikisakiName()
    {
        return torihikisakiName;
    }

    public void setTorihikisakiName(String torihikisakiName)
    {
        this.torihikisakiName = torihikisakiName;
    }

    public int getGoukei()
    {
        return goukei;
    }

    public void setGoukei(int goukei)
    {
        this.goukei = goukei;
    }

    public List<OutLineBean> getLines()
    {
        return lines;
    }

    @Override
    public String toString()
    {
        return "OutBean [torihikiDate=" + torihikiDate + ", torihikisakiName=" + torihikisakiName + ", goukei=" + goukei
                + ", lines=" + lines + "]";
    }

}

//------------------------------------
class OutLineBean
{
    private String shouhinName;
    private int suuryo;
    private int kingaku;

    public String getShouhinName()
    {
        return shouhinName;
    }

    public void setShouhinName(String shouhinName)
    {
        this.shouhinName = shouhinName;
    }

    public int getSuuryo()
    {
        return suuryo;
    }

    public void setSuuryo(int suuryo)
    {
        this.suuryo = suuryo;
    }

    public int getKingaku()
    {
        return kingaku;
    }

    public void setKingaku(int kingaku)
    {
        this.kingaku = kingaku;
    }

    @Override
    public String toString()
    {
        return "OutLineBean [shouhinName=" + shouhinName + ", suuryo=" + suuryo + ", kingaku=" + kingaku + "]";
    }

}