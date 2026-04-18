.class public Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRuleRestrictChatMembers;
.super Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UserPrivacySettingRuleRestrictChatMembers"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x17658bd1


# instance fields
.field public chatIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22430
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;-><init>()V

    .line 22431
    return-void
.end method

.method public constructor <init>([J)V
    .locals 0
    .param p1, "jArr"    # [J

    .line 22421
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;-><init>()V

    .line 22422
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRuleRestrictChatMembers;->chatIds:[J

    .line 22423
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22427
    const v0, 0x17658bd1

    return v0
.end method
