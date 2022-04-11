# Antra_HW4
Weather
1. change gateway setting
   change search service setting and use rest template with spring application name
    from  gateway -> search
                   -> details
    to    gateway -> search -> details
2. user can send multiple city names to search service and your response should return different cities' weather
    /search?cities=chi,ashburn,x2,x3
3. you should use multithreading if you need to send multi-requests at same time
    CompletableFuture + WebClient / RestTemplate
4. current project doesn't have any log and cannot track request id(uuid) (Partially Done)
    add filter in diff services
        get co-relation id from header
        put co-relation id in thread local
        clean up thread local id before give response
5. current project doesn't have any api documents(swagger) (Partially Done)
6. current project doesn't have any exception handling (Not done, will finish in the future)


* no fail tolerance if other services couldn't respond(retry / circuit breaker(hystrix))
* add security service
* add configuration service
