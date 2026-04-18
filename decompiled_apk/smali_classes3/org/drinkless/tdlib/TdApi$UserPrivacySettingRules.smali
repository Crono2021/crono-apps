.class public Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRules;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UserPrivacySettingRules"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x13389de5


# instance fields
.field public rules:[Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22466
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 22467
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;)V
    .locals 0
    .param p1, "userPrivacySettingRuleArr"    # [Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;

    .line 22457
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 22458
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRules;->rules:[Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;

    .line 22459
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22463
    const v0, 0x13389de5

    return v0
.end method
