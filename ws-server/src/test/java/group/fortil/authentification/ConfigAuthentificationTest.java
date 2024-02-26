package group.fortil.authentification;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConfigAuthentificationTest {

    @Mock
    private HttpSecurity httpSecurity;

    @InjectMocks
    private ConfigAuthentification configAuthentification;

    @Test
    void givenHttpSecurity_whenCheckingAuthorisation_thenReturnIfAllIsGood() throws Exception {
        // Given
        when(httpSecurity.csrf(any())).thenReturn(httpSecurity);
        when(httpSecurity.authorizeHttpRequests(any())).thenReturn(httpSecurity);
        when(httpSecurity.sessionManagement(any())).thenReturn(httpSecurity);
        when(httpSecurity.httpBasic(any())).thenReturn(httpSecurity);

        // When
        configAuthentification.filterChain(httpSecurity);

        // Then
        verify(httpSecurity).csrf(any());
        verify(httpSecurity).authorizeHttpRequests(any());
        verify(httpSecurity).sessionManagement(any());
        verify(httpSecurity).httpBasic(any()); // Ensure httpBasic() is invoked
        verify(httpSecurity).build();
    }
}

