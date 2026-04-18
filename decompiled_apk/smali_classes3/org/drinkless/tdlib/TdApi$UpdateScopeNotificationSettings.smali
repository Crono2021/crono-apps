.class public Lorg/drinkless/tdlib/TdApi$UpdateScopeNotificationSettings;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateScopeNotificationSettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x47c3348d


# instance fields
.field public notificationSettings:Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;

.field public scope:Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34868
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34869
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;)V
    .locals 0
    .param p1, "notificationSettingsScope"    # Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;
    .param p2, "scopeNotificationSettings"    # Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;

    .line 34858
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34859
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateScopeNotificationSettings;->scope:Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;

    .line 34860
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateScopeNotificationSettings;->notificationSettings:Lorg/drinkless/tdlib/TdApi$ScopeNotificationSettings;

    .line 34861
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34865
    const v0, -0x47c3348d

    return v0
.end method
