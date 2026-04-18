.class public Lorg/drinkless/tdlib/TdApi$UpdateUserPrivacySettingRules;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateUserPrivacySettingRules"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x366aad0a


# instance fields
.field public rules:Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRules;

.field public setting:Lorg/drinkless/tdlib/TdApi$UserPrivacySetting;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35108
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 35109
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$UserPrivacySetting;Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRules;)V
    .locals 0
    .param p1, "userPrivacySetting"    # Lorg/drinkless/tdlib/TdApi$UserPrivacySetting;
    .param p2, "userPrivacySettingRules"    # Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRules;

    .line 35098
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 35099
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateUserPrivacySettingRules;->setting:Lorg/drinkless/tdlib/TdApi$UserPrivacySetting;

    .line 35100
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateUserPrivacySettingRules;->rules:Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRules;

    .line 35101
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35105
    const v0, -0x366aad0a

    return v0
.end method
