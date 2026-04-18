.class public Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRuleAllowChatMembers;
.super Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UserPrivacySettingRuleAllowChatMembers"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7a1d7127


# instance fields
.field public chatIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22394
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;-><init>()V

    .line 22395
    return-void
.end method

.method public constructor <init>([J)V
    .locals 0
    .param p1, "jArr"    # [J

    .line 22385
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRule;-><init>()V

    .line 22386
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRuleAllowChatMembers;->chatIds:[J

    .line 22387
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22391
    const v0, -0x7a1d7127

    return v0
.end method
