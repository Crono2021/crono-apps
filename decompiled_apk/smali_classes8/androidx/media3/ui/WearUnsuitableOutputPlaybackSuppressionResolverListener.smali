.class public final Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;
.super Ljava/lang/Object;
.source "WearUnsuitableOutputPlaybackSuppressionResolverListener.java"

# interfaces
.implements Landroidx/media3/common/Player$Listener;


# static fields
.field public static final DEFAULT_PLAYBACK_SUPPRESSION_AUTO_RESUME_TIMEOUT_MS:J

.field private static final EXTRA_BLUETOOTH_SETTINGS_CLOSE_ON_CONNECT:Ljava/lang/String; = "EXTRA_CLOSE_ON_CONNECT"

.field private static final EXTRA_BLUETOOTH_SETTINGS_CONNECTION_ONLY:Ljava/lang/String; = "EXTRA_CONNECTION_ONLY"

.field private static final EXTRA_BLUETOOTH_SETTINGS_FILTER_TYPE:Ljava/lang/String; = "android.bluetooth.devicepicker.extra.FILTER_TYPE"

.field private static final EXTRA_OUTPUT_SWITCHER_PACKAGE_NAME:Ljava/lang/String; = "com.android.settings.panel.extra.PACKAGE_NAME"

.field private static final FILTER_TYPE_AUDIO:I = 0x1

.field private static final OUTPUT_SWITCHER_INTENT_ACTION_NAME:Ljava/lang/String; = "com.android.settings.panel.action.MEDIA_OUTPUT"


# instance fields
.field private final applicationContext:Landroid/content/Context;

.field private final autoResumeTimeoutAfterUnsuitableOutputSuppressionMs:J

.field private final clock:Landroidx/media3/common/util/Clock;

.field private unsuitableOutputPlaybackSuppressionStartRealtimeMs:J


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 102
    sget-object v0, Ljava/util/concurrent/TimeUnit;->MINUTES:Ljava/util/concurrent/TimeUnit;

    .line 103
    const-wide/16 v1, 0x5

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v0

    sput-wide v0, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->DEFAULT_PLAYBACK_SUPPRESSION_AUTO_RESUME_TIMEOUT_MS:J

    .line 102
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .line 121
    sget-wide v0, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->DEFAULT_PLAYBACK_SUPPRESSION_AUTO_RESUME_TIMEOUT_MS:J

    invoke-direct {p0, p1, v0, v1}, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;-><init>(Landroid/content/Context;J)V

    .line 122
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;J)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "autoResumeTimeoutMs"    # J

    .line 136
    sget-object v0, Landroidx/media3/common/util/SystemClock;->DEFAULT:Landroidx/media3/common/util/Clock;

    invoke-direct {p0, p1, p2, p3, v0}, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;-><init>(Landroid/content/Context;JLandroidx/media3/common/util/Clock;)V

    .line 137
    return-void
.end method

.method constructor <init>(Landroid/content/Context;JLandroidx/media3/common/util/Clock;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "autoResumeTimeoutMs"    # J
    .param p4, "clock"    # Landroidx/media3/common/util/Clock;

    .line 141
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 142
    const-wide/16 v0, 0x0

    cmp-long v0, p2, v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 143
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->applicationContext:Landroid/content/Context;

    .line 144
    iput-wide p2, p0, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->autoResumeTimeoutAfterUnsuitableOutputSuppressionMs:J

    .line 145
    iput-object p4, p0, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->clock:Landroidx/media3/common/util/Clock;

    .line 146
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v0, p0, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->unsuitableOutputPlaybackSuppressionStartRealtimeMs:J

    .line 147
    return-void
.end method

.method private static getSystemOrSystemUpdatedAppComponent(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/ComponentName;
    .locals 9
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "intent"    # Landroid/content/Intent;

    .line 210
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 211
    .local v0, "packageManager":Landroid/content/pm/PackageManager;
    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v1

    .line 212
    .local v1, "resolveInfos":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/pm/ResolveInfo;

    .line 213
    .local v3, "resolveInfo":Landroid/content/pm/ResolveInfo;
    iget-object v4, v3, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    .line 214
    .local v4, "activityInfo":Landroid/content/pm/ActivityInfo;
    if-eqz v4, :cond_0

    iget-object v5, v4, Landroid/content/pm/ActivityInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    if-nez v5, :cond_1

    .line 215
    goto :goto_0

    .line 217
    :cond_1
    iget-object v5, v4, Landroid/content/pm/ActivityInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 218
    .local v5, "appInfo":Landroid/content/pm/ApplicationInfo;
    const/16 v6, 0x81

    .line 220
    .local v6, "systemAndUpdatedSystemAppFlags":I
    iget v7, v5, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/2addr v7, v6

    if-eqz v7, :cond_2

    .line 221
    new-instance v2, Landroid/content/ComponentName;

    iget-object v7, v4, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    iget-object v8, v4, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-direct {v2, v7, v8}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v2

    .line 223
    .end local v3    # "resolveInfo":Landroid/content/pm/ResolveInfo;
    .end local v4    # "activityInfo":Landroid/content/pm/ActivityInfo;
    .end local v5    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v6    # "systemAndUpdatedSystemAppFlags":I
    :cond_2
    goto :goto_0

    .line 224
    :cond_3
    const/4 v2, 0x0

    return-object v2
.end method

.method private static launchSystemMediaOutputSwitcherUi(Landroid/content/Context;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .line 179
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.android.settings.panel.action.MEDIA_OUTPUT"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 181
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    move-result-object v0

    .line 182
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "com.android.settings.panel.extra.PACKAGE_NAME"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 183
    .local v0, "outputSwitcherLaunchIntent":Landroid/content/Intent;
    nop

    .line 184
    invoke-static {p0, v0}, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->getSystemOrSystemUpdatedAppComponent(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/ComponentName;

    move-result-object v1

    .line 185
    .local v1, "outputSwitcherSystemComponentName":Landroid/content/ComponentName;
    if-eqz v1, :cond_0

    .line 186
    invoke-virtual {v0, v1}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 187
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 189
    :cond_0
    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.settings.BLUETOOTH_SETTINGS"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 191
    const v3, 0x10008000

    invoke-virtual {v2, v3}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    move-result-object v2

    .line 192
    const-string v3, "EXTRA_CLOSE_ON_CONNECT"

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    move-result-object v2

    .line 193
    const-string v3, "EXTRA_CONNECTION_ONLY"

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    move-result-object v2

    .line 194
    const-string v3, "android.bluetooth.devicepicker.extra.FILTER_TYPE"

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v2

    .line 195
    .local v2, "bluetoothSettingsLaunchIntent":Landroid/content/Intent;
    nop

    .line 196
    invoke-static {p0, v2}, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->getSystemOrSystemUpdatedAppComponent(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/ComponentName;

    move-result-object v3

    .line 197
    .local v3, "bluetoothSettingsSystemComponentName":Landroid/content/ComponentName;
    if-eqz v3, :cond_1

    .line 198
    invoke-virtual {v2, v3}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 199
    invoke-virtual {p0, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 202
    .end local v2    # "bluetoothSettingsLaunchIntent":Landroid/content/Intent;
    .end local v3    # "bluetoothSettingsSystemComponentName":Landroid/content/ComponentName;
    :cond_1
    :goto_0
    return-void
.end method


# virtual methods
.method public onEvents(Landroidx/media3/common/Player;Landroidx/media3/common/Player$Events;)V
    .locals 6
    .param p1, "player"    # Landroidx/media3/common/Player;
    .param p2, "events"    # Landroidx/media3/common/Player$Events;

    .line 151
    iget-object v0, p0, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->applicationContext:Landroid/content/Context;

    invoke-static {v0}, Landroidx/media3/common/util/Util;->isWear(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 152
    return-void

    .line 154
    :cond_0
    const/4 v0, 0x6

    invoke-virtual {p2, v0}, Landroidx/media3/common/Player$Events;->contains(I)Z

    move-result v1

    const/4 v2, 0x5

    if-nez v1, :cond_1

    .line 155
    invoke-virtual {p2, v2}, Landroidx/media3/common/Player$Events;->contains(I)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 156
    :cond_1
    invoke-interface {p1}, Landroidx/media3/common/Player;->getPlayWhenReady()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 157
    invoke-interface {p1}, Landroidx/media3/common/Player;->getPlaybackSuppressionReason()I

    move-result v1

    const/4 v3, 0x3

    if-ne v1, v3, :cond_2

    .line 159
    invoke-interface {p1}, Landroidx/media3/common/Player;->pause()V

    .line 160
    iget-object v0, p0, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->clock:Landroidx/media3/common/util/Clock;

    invoke-interface {v0}, Landroidx/media3/common/util/Clock;->elapsedRealtime()J

    move-result-wide v0

    iput-wide v0, p0, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->unsuitableOutputPlaybackSuppressionStartRealtimeMs:J

    .line 161
    invoke-virtual {p2, v2}, Landroidx/media3/common/Player$Events;->contains(I)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 162
    iget-object v0, p0, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->applicationContext:Landroid/content/Context;

    invoke-static {v0}, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->launchSystemMediaOutputSwitcherUi(Landroid/content/Context;)V

    goto :goto_0

    .line 164
    :cond_2
    invoke-virtual {p2, v0}, Landroidx/media3/common/Player$Events;->contains(I)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 165
    invoke-interface {p1}, Landroidx/media3/common/Player;->getPlaybackSuppressionReason()I

    move-result v0

    if-nez v0, :cond_3

    iget-wide v0, p0, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->unsuitableOutputPlaybackSuppressionStartRealtimeMs:J

    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, v0, v2

    if-eqz v0, :cond_3

    iget-object v0, p0, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->clock:Landroidx/media3/common/util/Clock;

    .line 167
    invoke-interface {v0}, Landroidx/media3/common/util/Clock;->elapsedRealtime()J

    move-result-wide v0

    iget-wide v4, p0, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->unsuitableOutputPlaybackSuppressionStartRealtimeMs:J

    sub-long/2addr v0, v4

    iget-wide v4, p0, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->autoResumeTimeoutAfterUnsuitableOutputSuppressionMs:J

    cmp-long v0, v0, v4

    if-gez v0, :cond_3

    .line 169
    iput-wide v2, p0, Landroidx/media3/ui/WearUnsuitableOutputPlaybackSuppressionResolverListener;->unsuitableOutputPlaybackSuppressionStartRealtimeMs:J

    .line 170
    invoke-interface {p1}, Landroidx/media3/common/Player;->play()V

    .line 172
    :cond_3
    :goto_0
    return-void
.end method
