package CODE;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CrearLink {

    public CrearLink(String nombreLink) {
        String meetingId = "ODdlNGEzZjUtNGQ2OC00ZjVhLThkYjYtYzg1MjliMDJmNzE0";
        String tenantId = "b49db624-2546-4259-bf36-199c6e988033";
        String displayName = "Tutoría " + nombreLink;
        String teamsLink = generateLink(meetingId, tenantId, displayName);
        System.out.println("Teams link: " + teamsLink);
    }

    private static final String TEAMS_BASE_URL = "https://teams.microsoft.com/l/meetup-join/";

    public static String generateLink(String meetingId, String tenantId, String displayName) {
        try {
            String encodedMeetingId = URLEncoder.encode(meetingId, StandardCharsets.UTF_8.toString());
            String encodedTenantId = URLEncoder.encode(tenantId, StandardCharsets.UTF_8.toString());
            String encodedDisplayName = URLEncoder.encode(displayName, StandardCharsets.UTF_8.toString());
            return TEAMS_BASE_URL + encodedMeetingId + "?tenantId=" + encodedTenantId
                    + "&anon=true&orgName=Microsoft&displayName=" + encodedDisplayName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        new CrearLink("Cálculo I");
    }
}
