# micronaut_intercept_issue
Micronaut 1.3.3 and interceptors called several times compared to version 1.2.6.

Open gradle.properties and choose your Micronaut version.\
With 1.3.3, run app and call endpoints :

---
**http://127.0.0.1:8080/a**\
-> will output **1** log (from the interceptor):\
15:20:23.445 [pool-1-thread-1] WARN  f.q.m.intercept_issue.Interceptor - I'm interceptor at 2020-04-09 03:20:23.023

---
**http://127.0.0.1:8080/b**\
-> will output **3** logs !? (from the interceptor) :\
15:20:23.445 [pool-1-thread-1] WARN  f.q.m.intercept_issue.Interceptor - I'm interceptor at 2020-04-09 03:20:23.023\
15:20:23.445 [pool-1-thread-1] WARN  f.q.m.intercept_issue.Interceptor - I'm interceptor at 2020-04-09 03:20:23.023\
15:20:23.445 [pool-1-thread-1] WARN  f.q.m.intercept_issue.Interceptor - I'm interceptor at 2020-04-09 03:20:23.023\


---
Same procedure with micronaut version 1.2.6 works correctly with 1 log.