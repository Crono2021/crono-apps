.class public Lorg/drinkless/tdlib/TdApi$UpdateChatFolders;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatFolders"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x77189b93


# instance fields
.field public areTagsEnabled:Z

.field public chatFolders:[Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;

.field public mainChatListPosition:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41538
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41539
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;IZ)V
    .locals 0
    .param p1, "chatFolderInfoArr"    # [Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;
    .param p2, "i9"    # I
    .param p3, "z8"    # Z

    .line 41527
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41528
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatFolders;->chatFolders:[Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;

    .line 41529
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatFolders;->mainChatListPosition:I

    .line 41530
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatFolders;->areTagsEnabled:Z

    .line 41531
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41535
    const v0, 0x77189b93

    return v0
.end method
