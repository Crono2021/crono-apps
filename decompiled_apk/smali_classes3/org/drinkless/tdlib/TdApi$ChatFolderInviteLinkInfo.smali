.class public Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLinkInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatFolderInviteLinkInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x42b9751b


# instance fields
.field public addedChatIds:[J

.field public chatFolderInfo:Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;

.field public missingChatIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36124
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36125
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;[J[J)V
    .locals 0
    .param p1, "chatFolderInfo"    # Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;
    .param p2, "jArr"    # [J
    .param p3, "jArr2"    # [J

    .line 36113
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36114
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLinkInfo;->chatFolderInfo:Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;

    .line 36115
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLinkInfo;->missingChatIds:[J

    .line 36116
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLinkInfo;->addedChatIds:[J

    .line 36117
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36121
    const v0, 0x42b9751b

    return v0
.end method
