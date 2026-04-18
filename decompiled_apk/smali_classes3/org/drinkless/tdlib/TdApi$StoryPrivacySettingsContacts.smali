.class public Lorg/drinkless/tdlib/TdApi$StoryPrivacySettingsContacts;
.super Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryPrivacySettingsContacts"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2ff4afd


# instance fields
.field public exceptUserIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20508
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;-><init>()V

    .line 20509
    return-void
.end method

.method public constructor <init>([J)V
    .locals 0
    .param p1, "jArr"    # [J

    .line 20499
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;-><init>()V

    .line 20500
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryPrivacySettingsContacts;->exceptUserIds:[J

    .line 20501
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20505
    const v0, 0x2ff4afd

    return v0
.end method
