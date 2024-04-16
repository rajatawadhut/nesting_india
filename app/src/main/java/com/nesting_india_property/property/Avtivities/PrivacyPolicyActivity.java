package com.nesting_india_property.property.Avtivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.nesting_india_property.property.R;

public class PrivacyPolicyActivity extends AppCompatActivity {


    String privacy = " <p>\n" +
            "\tThe information provided by the user of www.NestingIndia.com shall be in accordance to the respective laws. The information/data provided by the user may be used by all divisions/sister concerns/ventures of the www.NestingIndia.com to carry out the purpose of the project, whereas in no case it shall be communicated/ transformed/spread to any company/third party or whatsoever for any other commercial usage without the consent of the user.\n" +
            "\t<br><br>\n" +
            "\tUpdating/modification/deletion of user's data/ information shall be done on the written request of the user himself or his representative or his authorized person only.\n" +
            "\t<br><br>\n" +
            "\tBy using this Site, the Users understand that all the information provided by you including and not limited to the company's information, property listing details are being submitted in the Site and by registering on this Site, you agree that the information posted by you is a public document that can be accessed by other Users of the Site. You agree and consent that nestingindia.com can use all the information provided by you to help you in the pursuit for find a buyer / seller by either forwarding the requirements to registered Users or by showcasing your property listing on the Site's search displays for the candidates (Visitors / Users) to see and contact.\n" +
            "\t<br><br>\n" +
            "\twww.NestingIndia.com is committed to respecting the online privacy of its Users and doesn't intend to sell, rent or share the Personal Information of Users to Third Party. The Site shall not transfer any such information unless it is legally required or to provide services to support your search for candidates. You agree to not hold nestingindia.com liable for any breach in privacy due to technical or any other means.\n" +
            "\t<br><br>\n" +
            "\twww.NestingIndia.com strives to provide a safe, secure User experience. The Site is committed to protect your Privacy but cannot guarantee / promise the same and you understand and agree that you assume all responsibility and risk for your use of the Site.\n" +
            "\t<br><br>\n" +
            "\tBeing an Intermediary, the role of the Site is limited to providing a platform for the Users to interact and we have no control over the data usage practiced by the Users who use the services of the Site.\n" +
            "\t<br><br>\n" +
            "\tBy using the Services of the Site you consent to collection, storage, and use of the personal information you provide (including any changes thereto as provided by you) for any of the Services offered by the Site and consent that www.NestingIndia.com can contact your for offers, updates, service-related information, send newsletters, for feedback, surveys, promotions, contests etc.\n" +
            "\t<br><br>\n" +
            "\tThe pages on the Site utilize \"cookies\" and other tracking technologies mainly to improve the User experience on our Site and analysis of traffic is undertaken to reveal the trends and statistics.\n" +
            "\t<br><br>\n" +
            "\twww.NestingIndia.com advises its User to exercise complete caution while completing online transactions and it is the sole responsibility of the User to verify and validate the information present on the site as well as the people whom they choose to interact with. nestingindia.com shall not be responsible for any loss / damage due to negligence of the User. You have sole authority to access and update all the information posted by you on the Site and it is your responsibility to keep the same updated. It is strictly advised that Users respect the Privacy of other Users as well as keep their profiles updated. Access to services of the Site including updation / deletion of profile may be restricted / denied if it comes to the notice of www.NestingIndia.com that this would violate anybody else's rights or if so requested by a legal entity.\n" +
            "\t<h3 style=\"text-align: center\" >LIMITATION OF LIABILITY</h3>\n" +
            "\t<ul style=\"margin-left:30px;\">\n" +
            "\t<li>www.NestingIndia.com only offers a platform to showcase the property / project listings and has no role in any transaction or communications and hence shall not be liable for any loss or damage of any sort arising out of the use and/or temporary or permanent discontinuation of its services. Notwithstanding anything to the contrary contained herein, www.NestingIndia.com, liability to you for any cause whatsoever, and regardless of the form of the action, will at all times be limited to the amount paid, if any, by you to nestingindia.com, for the Service during the term of membership.</li>\n" +
            "\t<li>www.NestingIndia.com being a public site with free access assumes no liability for the quality and genuineness of responses. Neting India cannot monitor the responses received by any User in response to the information posted by them and so displayed on the site. User should conduct its own background checks on the bonafide nature of all response(s). www.NestingIndia.com will not be liable for any inaccuracy of information on this website.</li>\n" +
            "\t<li>www.NestingIndia.com expressly disclaims any liability arising due to presence of any fraudulent information published on the site.</li>\n" +
            "\t<li>The User is warned against disclosure of any personal / confidential / sensitive information to any previous or current employee of the company. The User would do so solely at his / her own risk and Site / Company shall not be liable for the outcome of any such transaction of information including and not limited to damages for loss of profits or savings, business interruption, loss of information or repute.</li>\n" +
            "\t<li>That there are certain free and paid features which may not be incorporated in the mobile application version though they are a part of the original website since the mobile apps are designed to be compact and light to ensure a smooth experience. Each User hereby represents, warrants and agrees that the same shall be acceptable as a matter of fact and no requests to incorporate any such feature in the mobile app version would be initiated by the Users.</li>\n" +
            "\t<li>The User hereby agrees to take full responsibility to research well before making using of any information on the Site www.NestingIndia.com shall not be liable for any loss or damage of any sort arising out of the use and/or temporary or permanent discontinuation of its services. Notwithstanding anything to the contrary contained herein, www.NestingIndia.com liability to you for any cause whatsoever, and regardless of the form of the action, will at all times be limited to the amount paid, if any, by you to www.NestingIndia.com for the Service during the term of membership.</li>\n" +
            "\t<li>That there are certain free and paid features which may not be incorporated in the mobile application version though they are a part of the original website since the mobile apps are designed to be compact and light to ensure a smooth experience. Each User hereby represents, warrants and agrees that the same shall be acceptable as a matter of fact and no requests to incorporate any such feature in the mobile app version would be initiated by the Users.</li>\n" +
            "\t<li>www.NestingIndia.com may offer Complimentary leads to the Users with certain paid packages / some special schemes but the Users shall not in any circumstance hold www.NestingIndia.com liable for the same as this is subject to availability. These are requirements posted by buyers and their receipt is based on the popularity, trends etc. which are not governed by www.NestingIndia.com and hence cannot be guaranteed. www.NestingIndia.com would try to forward the leads that match the Users requirements but is not liable for the accuracy and authenticity of the information.</li>\n" +
            "\t\n" +
            "\t</ul><br>\n" +
            "\t<h3 style=\"text-align: center\" >REFUND PROPERTY LEADS</h3>\n" +
            "\tRequest for refund of Property leads on account of non-contactable contact details need to be brought in notice within 5 days of purchase, failing which the request would not be entertained.\n" +
            "\t<br><br>\n" +
            "\tNo refund requests owing to cancelled or fulfilled leads would be entertained as these are beyond the scope of the Site since we have no role in monitoring the deal finalization, transactions or preferences of the Users.\n" +
            "\t<br><br>\n" +
            "\tThe refund request cannot exceed 25% of the assigned Property leads quota and the request can be processed directly via the member folder in which the refund option would be inaccessible once the limit is exceeded irrespective of the reason cited for refund.<br>\n" +
            "\t<h3 style=\"text-align: center\" >DISCLAIMER</h3>\n" +
            "\t<ul style=\"margin-left:30px;\">\n" +
            "\t<li>The Company shall not be liable for any loss of information howsoever caused whether as a result of any interruption, suspension, or termination of the Service or otherwise, or for the contents, accuracy or quality of information available, received or transmitted through the Service.</li>\n" +
            "\t<li>The User shall be solely responsible, and the Company shall not be liable in any manner whatsoever, for ensuring that in using the Service, all applicable laws, rules and regulations for the use of systems, service or equipment shall be at all times complied with.</li>\n" +
            "\t<li>The Company makes no representations and warranties of any kind, whether expressed or implied, for the Services and in relation to the accuracy or quality of any information transmitted or obtained through the Services of www.NestingIndia.com</li>\n" +
            "\t<li>The Company's liability under this Agreement shall not in any event exceed the total amount of fees and charges paid by the User to the Company for the period immediately preceding two (2) months prior to the incident that has resulted in the relevant claim.</li>\n" +
            "\t<li>The Company shall not be liable for any loss or damages sustained by reason of any disclosure (inadvertent or otherwise) of any information concerning the User's account and particulars nor for any error, omission or inaccuracy with respect to any information so disclosed.</li>\n" +
            "\t<li>The Company neither guarantees nor offers any warranty about the credentials, status or authenticity of the buyer/seller/real estate agent / builder etc. contacting the Users after accessing the information/data posted by the Users.</li>\n" +
            "\t<li>The Company does not warrant that www.NestingIndia.com or any of the web sites linked to www.NestingIndia.com be free of any operational errors or that it will be free of any virus, worm, or other harmful component.</li>\n" +
            "\t<li>The User acknowledges that it is not the Company's policy to exercise editorial control over and to edit or amend any data or contents of any emails or posting or any information that may be inserted or made available or transmitted to a third party in or through www.NestingIndia.com The Company may refuse, suspend, terminate, delete or amend any artwork, materials, information or content of any data or information or posting so as, in the sole opinion of the Company, to comply with the legal or moral obligations as placed on the Company and to avoid infringing a third party's rights or any other rules, standards or codes of practices that may be applicable to the posting or www.NestingIndia.com or the internet. It is the sole prerogative and responsibility of the User to check the authenticity of all or any response/ inquiry received or information displayed. www.NestingIndia.com is a public site with free access and assumes no liability for the quality and genuineness of responses.</li>\n" +
            "\t<li>www.NestingIndia.com neither guarantees nor offers any warranty about the credentials of the contacted parties including prospective buyer / seller / builder / real estate agent / User and it is for the users to test, analyse and verify the same at their own end.</li>\n" +
            "\t<li>The data fed by the User can be updated by the User alone and is solely their liability so www.NestingIndia.com is not responsible for the updated status of the information.</li>\n" +
            "\t<li>The User shall ensure that while using the Service, all prevailing and applicable laws, rules and regulations, directly or indirectly for the use of systems, service or equipment shall at all times, be strictly complied with by the User and the Company shall not be liable in any manner whatsoever for default of any nature regarding the same, by the User.</li>\n" +
            "\t<li>The Site is controlled and operated from India and the Site makes no representation that the materials are appropriate or will be available for use in other parts of the World. If you use this Site from outside India, you are entirely responsible for compliance with all applicable local laws as well as international conventions and treats.</li>\n" +
            "\t<li>Users are strongly advised to independently verify the authenticity of any Pre-Launch offers received by them. The Site does not endorse investment in any projects which have not received official sanction and have not been launched by the Builder/Promoter; Users dealing in such projects shall be doing so entirely at their risk and responsibility.</li>\n" +
            "\t<li>Users need to make necessary background checks and verification on any information provided by the Users related to the Projects / Properties before making investments www.NestingIndia.com assumes no liability for the quality and genuineness of the Projects / Properties displayed.</li>\n" +
            "\t</ul>\n" +
            "\t<h3 style=\"text-align: center\" >USE OF DATA</h3>\n" +
            "\tThe User hereby agrees and irrevocably authorizes the Company to:\n" +
            "\t<ul style=\"margin-left:30px;\">\n" +
            "\t<li>Use any data and information supplied by the User in connection with this Agreement for the Company's own purpose, to the company supplying such data and information to any other associated companies or selected third parties including search engines.</li>\n" +
            "\t<li>Use any data furnished by the User in order to float offers or send mails regarding specific services and such mails may not been proclaimed or deemed to be unsolicited communique.</li>\n" +
            "\t<li>Allow all data and information supplied by the User in using the Service to remain at www.NestingIndia.com for the use of the Company in accordance with service agreement with the User, notwithstanding the termination or suspension of the Service to the User herein. Unless the User informs the Company to delete all such data and information following the termination or suspension of the Service to the User, such data and information remain in the Company's property, records and databases.</li>\n" +
            "\t\n" +
            "\t</ul>\n" +
            "\t<h3 style=\"text-align: center\" >RERA DISCLAIMER</h3>\n" +
            "\tThe Users who are sellers such as Project Developers / Builders / Real Estate Agents shall obtain necessary registration under the said Act and ensure all necessary compliance with the rules, regulations and guidelines of RERA Act 2016. It is mandatory that these Users disclose all the requisite information and relevant details as prescribed in the RERA Act 2016. www.NestingIndia.com neither guarantees nor offers any warranty about the information including RERA credentials posted by the Project Developers / Builders / Real Estate Agents as well as their compliance.\n" +
            "\t<br><br>\n" +
            "\tThe Site recommends that the Users refer the respective RERA websites, as may be applicable, of the respective State where the Project / Property is registered for complete procedures as well as accurate information related Project / Property posted on the Site by Project Developers / Builders / Real Estate Agents and advises the Users to take all efforts to make necessary verifications before proceeding for finalization / transactions.\n" +
            "\t<br><br>\n" +
            "\tIn no event the Site will be liable for any damages including, without limitation, indirect or consequential damages, any claims arising due to inaccurate / discrepant information posted on the Site.\n" +
            "\t<br><br>\n" +
            "\tThe Company makes no representations and warranties of any kind, whether expressed or implied, for the Services and in relation to the accuracy or quality of any information transmitted or obtained at www.NestingIndia.com\n" +
            "\t<h3 style=\"text-align: center\" >INDEMNITY</h3>\n" +
            "\tYou agree to indemnify and hold www.NestingIndia.com, its subsidiaries, affiliates, officers, agents, and other partners and employees, harmless from any loss, liability, claim, or demand, including reasonable attorney's fees, made by any third party due to or arising out of your use of the Service in violation of this Agreement and/or arising from a breach of these Terms of Use and/or any breach of your representations and warranties set forth above.\n" +
            "\t<h3 style=\"text-align: center\" >VARIATION</h3>\n" +
            "\tThe Company reserves the right to amend the terms and conditions contained herein and in the Services Guide at any time upon notice (in such form as may be determined by the Company) to the User.\n" +
            "\t<br><br>\n" +
            "\tThe Terms and Conditions of this agreement will be updated from time to time and posted at www.NestingIndia.com. The User should visit the site periodically to review the Terms and Conditions. For the avoidance of doubt, the User's continued use of the Service constitutes an affirmation and acknowledgement of the amended terms and conditions.\n" +
            "\t<h3 style=\"text-align: center\" >PAYMENT AND REFUND POLICY</h3>\n" +
            "\t<h4>Payment for memberships:</h4>\n" +
            "\tAll payments for services at www.NestingIndia.com have to be made in favour of  Nesting India only. All payments need to be made on 100% advance basis to continue to use uninterrupted Paid Services.\n" +
            "\t<br><br>\n" +
            "\tWe have not authorized any individual or organization to collect payments in any other name (i.e. any other individual or organization name) or via personal Western Union or personal Paypal Accounts for any services rendered by www.NestingIndia.com. You are informed that under no circumstances will www.NestingIndia.com be liable for any damage caused due to your transactions / payments made to / in favour of such fraudulent individuals or organizations. To protect your interests, please contact us immediately if any such fraudulent individual or organization tries to mislead you.\n" +
            "\t<br><br>\n" +
            "\tThe User, who is liable to pay Subscription Fees, shall pay it on demand even if the User disputes the same for any reason. In the event that the Company deciding the dispute to be in the User's favor, the Company shall refund to the User any excess amount paid by the Member free of interest. In the event of late payment by the User of any sums due under this Agreement, the Membership and the services would stand terminated.\n" +
            "\t<h3 style=\"text-align: center\" >Refund / Money Back Policy:</h3>\n" +
            "\tOnce subscribed, the payment made by the User for Paid service is not refundable and no claim for refund would be entertained. www.NestingIndia.com neither offers any guarantees for the accuracy, timeliness, authenticity nor advocates any of the content posted by the other Users. All the services are on a best effort basis.\n" +
            "\t<h3 style=\"text-align: center\" >Refund on the basis of fraudulent transactions</h3>\n" +
            "\tThe User is solely responsible for maintaining confidentiality, as well as all the activities and transmission performed through his My Folder. He/she shall be solely responsible for carrying out any online or off-line transaction involving credit cards / debit cards or such other forms of instruments or documents for making such transactions www.NestingIndia.com assumes no responsibility or liability for their improper use of information relating to such usage of credit cards / debit cards used by the subscriber online / off-line.\n" +
            "\t<h3 style=\"text-align: center\" >Refund on the basis of change in preference / delay in process</h3>\n" +
            "\tAs we at www.NestingIndia.com keep up high interactions with our clients and carry out the entire process with their approval thus there is no provision for any kind of full or partial refund.\n" +
            "\t<br><br>\n" +
            "\tOnce an order is placed it cannot be cancelled as it is sent for processing immediately. Your personal preferences changed in the course of time, cannot serve a reason for refund or charge back.\n" +
            "\t<h3 style=\"text-align: center\" >SUSPENSION / TERMINATION OF SERVICES</h3>\n" +
            "\twww.NestingIndia.com reserves the right to partially suspend the User's access to certain features, panels, access points or fully terminate a User's Account at any time without assigning any reason or notice to the User (Free and Paid Members) in order to protect the interests of other Users of www.NestingIndia.com and / or the interests of www.NestingIndia.com.\n" +
            "\t<br><br>\n" +
            "\tTermination or suspension either fully or partially as deemed fit by www.NestingIndia.com may be on reasonable grounds to suspect / on receipt of complaint / a belief / an investigation / a notification from law-making bodies or governing authorities and can be done for the following reasons:\n" +
            "\t<ul style=\"margin-left:30px;\">\n" +
            "\t<li>If there is any breach of the provisions of this Agreement by the User(s).</li>\n" +
            "\t<li>If the information provided by the User(s) is untrue, inaccurate or is not current or complete, or if the User(s) unlawfully uses another person's or business entity's name or impersonates another person or business identity in any manner.</li>\n" +
            "\t<li>If the User's actions may cause financial loss or legal liability to other User(s), or www.NestingIndia.com or its affiliates.</li>\n" +
            "\t<li>If the User(s) is engaged in misuse or fraudulent use of the Services or involved in illegal / prohibited / inappropriate communications / activities / transactions</li>\n" +
            "\t<li>If the User(s) posts any material that is unrelated to the services extended by the Site or uses the Site for spamming</li>\n" +
            "\t<li>If the User(s) is involved in unauthorized access, use, modification, or control of the Site database, network or related services.</li>\n" +
            "\t<li>If the User(s) accesses another User(s) account by obtaining another registered User(s) Username and/or Password.</li>\n" +
            "\t<li>If the User(s) infringes the intellectual property rights of any other person or business entity.</li>\n" +
            "\t<li>If the User(s) activity that may not be in accordance with the ethics and honest business practices.</li>\n" +
            "\t\n" +
            "\t</ul>\n" +
            "\t<br>\n" +
            "\tWith such termination, the User(s) would lose the authority to use the Free and Paid Services of the Site and would not be entitled to register again with new User information unless permitted by www.NestingIndia.com in writing. No membership charges / subscription fee paid by the User(s) will be refunded in case of termination. The User(s) acknowledge and agree that any direct or indirect damage caused due to such termination are not a liability of nestingindia.com.\n" +
            "\t<h3 style=\"text-align: center\" >USER DISPUTES</h3>\n" +
            "\tThe Users are solely responsible for your interactions at www.NestingIndia.com and www.NestingIndia.com reserves the right, but has no obligation, to monitor disputes between Members.\n" +
            "\t<br><br>\n" +
            "\twww.NestingIndia.com will not be party to any legal proceedings between User and any other registered or free User for any transactions through the Site. www.NestingIndia.com will always abide by governing / legal authorities order and cooperate fully through the process, but the costs of the same shall be recovered from the party that has implicated PlaceentIndia.com in such case.\n" +
            "\t<h3 style=\"text-align: center\" >MATTER OF DISPUTES AND JURISDICTIONAL ASPECTS</h3>\n" +
            "\tFor any kind of legal dispute related to www.NestingIndia.com would be dealt in only territory of Nagpur. All the legal issues are subjected only to pertinent contemporary's laws in force at NAGPUR to the jurisdiction of courts located in NAGPUR only.\n" +
            "\t<h3 style=\"text-align: center\" >GOVERNING LAW AND JURISDICTION</h3>\n" +
            "\tThis Agreement and any dispute or matter arising from incidental use www.NestingIndia.com is governed by the laws of India and the User and the Company hereby submit to the exclusive jurisdiction of the courts at Nagpur, India. This Agreement, accepted upon use of the Site and further affirmed by becoming a User of the www.NestingIndia.com, contains the entire agreement between you and www.NestingIndia.com regarding the use of the Site and/or the Service. If any provision of this Agreement is held invalid, the remainder of this Agreement shall continue in full force and effect.\n" +
            "\t\n" +
            "\t</p>\n" +
            "\n" +
            "\n" +
            "\n" +
            "                                              ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Privacy Policy");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });



        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView text_privacy = findViewById(R.id.text_privacy);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            text_privacy.setText(Html.fromHtml(privacy, Html.FROM_HTML_MODE_COMPACT));
        } else {
            text_privacy.setText(Html.fromHtml(privacy));
        }

    }
}