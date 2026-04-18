.class public Lorg/drinkless/tdlib/TdApi$StoryPrivacySettingsSelectedUsers;
.super Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryPrivacySettingsSelectedUsers"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x70669b3a


# instance fields
.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20544
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;-><init>()V

    .line 20545
    return-void
.end method

.method public constructor <init>([J)V
    .locals 0
    .param p1, "jArr"    # [J

    .line 20535
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;-><init>()V

    .line 20536
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryPrivacySettingsSelectedUsers;->userIds:[J

    .line 20537
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20541
    const v0, -0x70669b3a

    return v0
.end method
