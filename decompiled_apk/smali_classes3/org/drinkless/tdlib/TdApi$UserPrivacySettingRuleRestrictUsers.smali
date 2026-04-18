.class public Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRuleRestrictUsers;
.super Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UserPrivacySettingRuleRestrictUsers"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x251f1eea


# instance fields
.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22448
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;-><init>()V

    .line 22449
    return-void
.end method

.method public constructor <init>([J)V
    .locals 0
    .param p1, "jArr"    # [J

    .line 22439
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;-><init>()V

    .line 22440
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRuleRestrictUsers;->userIds:[J

    .line 22441
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22445
    const v0, 0x251f1eea

    return v0
.end method
