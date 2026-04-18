.class public Lorg/drinkless/tdlib/TdApi$NotificationSettingsScopeChannelChats;
.super Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "NotificationSettingsScopeChannelChats"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x20aa0588


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 4325
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 4330
    const v0, 0x20aa0588

    return v0
.end method
