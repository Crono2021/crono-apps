.class public Lorg/drinkless/tdlib/TdApi$ArchiveChatListSettings;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ArchiveChatListSettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3f176aa4


# instance fields
.field public archiveAndMuteNewChatsFromUnknownUsers:Z

.field public keepChatsFromFoldersArchived:Z

.field public keepUnmutedChatsArchived:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35706
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35707
    return-void
.end method

.method public constructor <init>(ZZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z
    .param p3, "z10"    # Z

    .line 35695
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35696
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ArchiveChatListSettings;->archiveAndMuteNewChatsFromUnknownUsers:Z

    .line 35697
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ArchiveChatListSettings;->keepUnmutedChatsArchived:Z

    .line 35698
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ArchiveChatListSettings;->keepChatsFromFoldersArchived:Z

    .line 35699
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35703
    const v0, 0x3f176aa4

    return v0
.end method
