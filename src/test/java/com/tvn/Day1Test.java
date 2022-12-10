package com.tvn;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day1Test {

    @Test
    void Nam_La_So_Nguyen_To(){
        Assert.assertTrue(Day1.laSoNguyenTo(5));
    }

    @Test
    void Bay_La_So_Nguyen_To(){
        Assert.assertTrue(Day1.laSoNguyenTo(7));
    }

    @Test
    void Chin_Khong_La_So_Nguyen_To(){
        Assert.assertFalse(Day1.laSoNguyenTo(9));
    }

    @Test
    void Muoi_Mot_La_So_Nguyen_To(){
        Assert.assertTrue(Day1.laSoNguyenTo(11));
    }

    @Test
    void Muoi_Bay_La_So_Nguyen_To(){
        Assert.assertTrue(Day1.laSoNguyenTo(17));
    }


    @Test
    void A_La_Nguyen_Am(){
        Assert.assertTrue(Day1.laNguyenAm("A"));
    }

    @Test
    void a_La_Nguyen_Am(){
        Assert.assertTrue(Day1.laNguyenAm("a"));
    }

    @Test
    void b_La_Phu_Am(){
        Assert.assertFalse(Day1.laNguyenAm("b"));
    }

    @Test
    void c_La_Phu_Am(){
        Assert.assertFalse(Day1.laNguyenAm('c'));
    }

    /**
     * 2004, 2008, 2012, 2016, 2020, 2024, 2028, 2032, 2036, 2040, 2044, 2048, 2052, 2056, 2060, 2064, 2068, 2072, 2076, 2080, 2084, 2088, 2092, 2096.
     */

    @Test
    void Hai_004_La_Nam_Nhuan(){
        Assert.assertTrue(Day1.laNamNhuan(2004));
    }

    @Test
    void Hai_008_La_Nam_Nhuan(){
        Assert.assertTrue(Day1.laNamNhuan(2008));
    }

    @Test
    void Hai_012_La_Nam_Nhuan(){
        Assert.assertTrue(Day1.laNamNhuan(2012));
    }

    @Test
    void Hai_024_La_Nam_Nhuan(){
        Assert.assertTrue(Day1.laNamNhuan(2024));
    }

    @Test
    void Hai_022_Khong_La_Nam_Nhuan(){
        Assert.assertFalse(Day1.laNamNhuan(2022));
    }

    @Test
    void password_less_than_10_chars(){
        Assert.assertFalse(Day1.isPasswordComplex("1212"));
    }

    @Test
    void password_valid(){
        Assert.assertTrue(Day1.isPasswordComplex("zaq1XSW@#!0"));
    }
}
