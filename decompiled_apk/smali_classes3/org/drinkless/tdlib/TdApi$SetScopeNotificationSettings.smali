.class public Lorg/drinkless/tdlib/TdApi$SetScopeNotificationSettings;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetScopeNotificationSettings"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7a3049c6


# instance fields
.field public notificationSettings:Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;

.field public scope:Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31888
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31889
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;)V
    .locals 0
    .param p1, "notificationSettingsScope"    # Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;
    .param p2, "scopeNotificationSettings"    # Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;

    .line 31878
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31879
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetScopeNotificationSettings;->scope:Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;

    .line 31880
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetScopeNotificationSettings;->notificationSettings:Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;

    .line 31881
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31885
    const v0, -0x7a3049c6

    return v0
.end method
