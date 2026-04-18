.class final Landroidx/media3/common/util/NetworkTypeObserver$Api31;
.super Ljava/lang/Object;
.source "NetworkTypeObserver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/common/util/NetworkTypeObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "Api31"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/common/util/NetworkTypeObserver$Api31$DisplayInfoCallback;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 228
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static disambiguate4gAnd5gNsa(Landroid/content/Context;Landroidx/media3/common/util/NetworkTypeObserver;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "instance"    # Landroidx/media3/common/util/NetworkTypeObserver;

    .line 232
    :try_start_0
    const-string/jumbo v0, "phone"

    .line 233
    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    .line 234
    .local v0, "telephonyManager":Landroid/telephony/TelephonyManager;
    new-instance v1, Landroidx/media3/common/util/NetworkTypeObserver$Api31$DisplayInfoCallback;

    invoke-direct {v1, p1}, Landroidx/media3/common/util/NetworkTypeObserver$Api31$DisplayInfoCallback;-><init>(Landroidx/media3/common/util/NetworkTypeObserver;)V

    .line 235
    .local v1, "callback":Landroidx/media3/common/util/NetworkTypeObserver$Api31$DisplayInfoCallback;
    invoke-virtual {p0}, Landroid/content/Context;->getMainExecutor()Ljava/util/concurrent/Executor;

    move-result-object v2

    invoke-virtual {v0, v2, v1}, Landroid/telephony/TelephonyManager;->registerTelephonyCallback(Ljava/util/concurrent/Executor;Landroid/telephony/TelephonyCallback;)V

    .line 238
    invoke-virtual {v0, v1}, Landroid/telephony/TelephonyManager;->unregisterTelephonyCallback(Landroid/telephony/TelephonyCallback;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 242
    .end local v0    # "telephonyManager":Landroid/telephony/TelephonyManager;
    .end local v1    # "callback":Landroidx/media3/common/util/NetworkTypeObserver$Api31$DisplayInfoCallback;
    goto :goto_0

    .line 239
    :catch_0
    move-exception v0

    .line 241
    .local v0, "e":Ljava/lang/RuntimeException;
    const/4 v1, 0x5

    invoke-static {p1, v1}, Landroidx/media3/common/util/NetworkTypeObserver;->access$200(Landroidx/media3/common/util/NetworkTypeObserver;I)V

    .line 243
    .end local v0    # "e":Ljava/lang/RuntimeException;
    :goto_0
    return-void
.end method
