package org.apereo.cas.web.flow.resolver.impl;

import org.apereo.cas.CentralAuthenticationService;
import org.apereo.cas.authentication.AuthenticationServiceSelectionPlan;
import org.apereo.cas.authentication.AuthenticationSystemSupport;
import org.apereo.cas.authentication.MultifactorAuthenticationProviderSelector;
import org.apereo.cas.services.ServicesManager;
import org.apereo.cas.ticket.registry.TicketRegistrySupport;
import org.apereo.cas.web.cookie.CasCookieBuilder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * This is {@link AbstractCasMultifactorAuthenticationWebflowEventResolver} that provides parent
 * operations for all child event resolvers to handle MFA webflow changes.
 *
 * @author Travis Schmidt
 * @since 6.0.0
 */
@Slf4j
public abstract class AbstractCasMultifactorAuthenticationWebflowEventResolver extends AbstractCasWebflowEventResolver {

    /**
     * The mfa selector.
     */
    protected final MultifactorAuthenticationProviderSelector multifactorAuthenticationProviderSelector;

    public AbstractCasMultifactorAuthenticationWebflowEventResolver(final AuthenticationSystemSupport authenticationSystemSupport,
                                                                    final CentralAuthenticationService centralAuthenticationService,
                                                                    final ServicesManager servicesManager,
                                                                    final TicketRegistrySupport ticketRegistrySupport,
                                                                    final CasCookieBuilder warnCookieGenerator,
                                                                    final AuthenticationServiceSelectionPlan authenticationRequestServiceSelectionStrategies,
                                                                    final MultifactorAuthenticationProviderSelector multifactorAuthenticationProviderSelector,
                                                                    final ApplicationEventPublisher eventPublisher,
                                                                    final ConfigurableApplicationContext applicationContext) {
        super(authenticationSystemSupport, centralAuthenticationService, servicesManager, ticketRegistrySupport,
            warnCookieGenerator, authenticationRequestServiceSelectionStrategies,
            eventPublisher, applicationContext);
        this.multifactorAuthenticationProviderSelector = multifactorAuthenticationProviderSelector;
    }
}
