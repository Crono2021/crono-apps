.class public Lorg/drinkless/tdlib/TdApi$GetScopeNotificationSettings;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetScopeNotificationSettings"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3b57dab1


# instance fields
.field public scope:Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13542
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13543
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;)V
    .locals 0
    .param p1, "notificationSettingsScope"    # Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;

    .line 13533
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13534
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetScopeNotificationSettings;->scope:Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;

    .line 13535
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13539
    const v0, -0x3b57dab1

    return v0
.end method
