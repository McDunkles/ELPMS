<#import "template.ftl" as layout>
<@layout.registrationLayout displayMessage=!messagesPerField.existsError('username','password') displayInfo=realm.password && realm.registrationAllowed && !registrationDisabled??; section>
        <form id="kc-form-login" onsubmit="login.disabled = true; return true;" action="${url.loginAction}" method="post">
                <div class="card">
                    <div class="card-logo"></div>

                    <div class="card-help">Need help? <span onClick="onClickRedirectInPage('/contact-us')" class="card-help-contact">Contact us</span></div>

                    <div class="card-input card-input-first">
                        <div class="<#if messagesPerField.existsError('username','password')>error-input-label</#if> card-input-label">Email</div>

                        <div class="card-input-wrapper">
                            <input class="<#if messagesPerField.existsError('username','password')>error-input</#if> card-input-line" id="username" name="username" value="${(login.username!'')}" />
                        </div>

                        <#if messagesPerField.existsError('username','password')>
                            <span id="input-error" class="card-input-line-error" aria-live="polite">
                                    ${kcSanitize(messagesPerField.getFirstError('username','password'))?no_esc}
                            </span>
                        </#if>
                    </div>

                    <div class="card-input">
                        <div class="<#if messagesPerField.existsError('username','password')>error-input-label</#if> card-input-label">Password</div>

                        <div class="card-input-wrapper">
                            <input class="<#if messagesPerField.existsError('username','password')>error-input</#if> card-input-line" type="password" id="password" name="password" type="password" />
                        </div>

                        <#if messagesPerField.existsError('username','password')>
                            <span id="input-error" class="card-input-line-error" aria-live="polite">
                                    ${kcSanitize(messagesPerField.getFirstError('username','password'))?no_esc}
                            </span>
                        </#if>
                    </div>

                    <input type="submit" class="card-button" onsubmit="login.disabled = true; return true;" action="${url.loginAction}" method="post" value="Login" />

                    <div class="card-wrapper">
                        <a href="/" class="card-item">Forgot password?</a>
                        <div onClick="onClickRedirectInPage('/signup')" class="card-item">Sign up</div>
                    </div>
                </div>
        </form>

  <script>
      function onClickRedirectInPage(pageLink) {
           const params = new URLSearchParams(document.location.search);
           const redirectUri = params.get("redirect_uri");
           const newDomain = (new URL(redirectUri));
           const newHost = newDomain.protocol + "//" + newDomain.host;

         window.location.href = newHost + pageLink;
      }
  </script>

</@layout.registrationLayout>
