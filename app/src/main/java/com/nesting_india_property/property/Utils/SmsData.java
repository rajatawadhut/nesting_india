package com.nesting_india_property.property.Utils;

public class SmsData {
/*

    $otpCode = $randomId;
    $url = "www.nestingindia.com/contact";
    $ch = curl_init('https://www.txtguru.in/imobile/api.php?');
    curl_setopt($ch, CURLOPT_POST, 1);
    curl_setopt($ch, CURLOPT_POSTFIELDS, "username=9ninesquareproperty&password=99700151&source=NSQPRP&dmobile=".$mobileNumber.
            "&dltentityid=1501782580000035825&dltheaderid=1505164559938666054&dlttempid=1507164560030455513&message=
            Welcome to Nesting India! Your OTP code is ".$otpCode.". Please DO NOT share this OTP with anyone. Contact us for any query at ".$url."");
            curl_setopt($ch, CURLOPT_RETURNTRANSFER,1);
    $data = curl_exec($ch);

    Welcome to Nesting India! Your OTP code is 5288. Please DO NOT share this OTP with anyone.
    Contact us for any query at www.nestingindia.com/contact 1507164560030455513
*/



/*

    String atthe = "@";
    String url = "www.nestingindia.com/contact";
    public String Username = "shailendramahanande";
    public String Password = "48601128";
    public String source = "NSQPRP";
    public String dltentityid = "1501782580000035825";
    public String dltheaderid = "1505164559938666054";
    public String dlttempid = "1507164560030455513";
    public String subject = "Otp Of Nesting India";
    public String message = "Welcome to Nesting India! Your OTP code is ";
    //    public String message2= ". Please DO NOT share this OTP with anyone. Contact for any query @\n" +"www.nestingindia.com/contact";
    public String message2= ". Please DO NOT share this OTP with anyone. Contact us for any query at " +url;

    public String token = "hguyngjkkfuids_koihacknhikrskta_hjkhdgh789fjghju";

    public SmsData() {
    }


*/

    String atthe = "@";
    String url = "www.nestingindia.com/contact";
    public String Username = "shailendramahanande";
    public String Password = "48601128"; // correct
//    public String Password = "486"; // wrong
    public String source = "NSTIND"; // correct
//    public String source = "N"; // wrong
    public String dltentityid = "1501394680000022547";
    public String dltheaderid = "1505161285152442705";
    public String dlttempid = "1507162065221907548";
    public String subject = "Otp Of Nesting India";
    public String message = "Dear user, Nesting India verification OTP code is ";
//    public String message2= ". Please DO NOT share this OTP with anyone. Contact for any query @\n" +"www.nestingindia.com/contact";
    public String message2= ". Please DO NOT share this OTP with anyone. Contact for any query " + atthe+" "+url;

    public String token = "hguyngjkkfuids_koihacknhikrskta_hjkhdgh789fjghju";

    public SmsData() {
    }
}
