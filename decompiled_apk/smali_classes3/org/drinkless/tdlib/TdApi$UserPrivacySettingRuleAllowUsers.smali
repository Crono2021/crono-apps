.class public Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRuleAllowUsers;
.super Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UserPrivacySettingRuleAllowUsers"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4238562e


# instance fields
.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22412
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;-><init>()V

    .line 22413
    return-void
.end method

.method public constructor <init>([J)V
    .locals 0
    .param p1, "jArr"    # [J

    .line 22403
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;-><init>()V

    .line 22404
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRuleAllowUsers;->userIds:[J

    .line 22405
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22409
    const v0, 0x4238562e

    return v0
.end method
