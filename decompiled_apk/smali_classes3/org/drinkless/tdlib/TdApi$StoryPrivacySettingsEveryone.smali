.class public Lorg/drinkless/tdlib/TdApi$StoryPrivacySettingsEveryone;
.super Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryPrivacySettingsEveryone"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x35194263


# instance fields
.field public exceptUserIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20526
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;-><init>()V

    .line 20527
    return-void
.end method

.method public constructor <init>([J)V
    .locals 0
    .param p1, "jArr"    # [J

    .line 20517
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;-><init>()V

    .line 20518
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryPrivacySettingsEveryone;->exceptUserIds:[J

    .line 20519
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20523
    const v0, 0x35194263

    return v0
.end method
