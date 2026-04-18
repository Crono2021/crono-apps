.class public Lorg/drinkless/tdlib/TdApi$ProcessChatFolderNewChats;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ProcessChatFolderNewChats"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x594df2e0


# instance fields
.field public addedChatIds:[J

.field public chatFolderId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29408
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29409
    return-void
.end method

.method public constructor <init>(I[J)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "jArr"    # [J

    .line 29398
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29399
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ProcessChatFolderNewChats;->chatFolderId:I

    .line 29400
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ProcessChatFolderNewChats;->addedChatIds:[J

    .line 29401
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29405
    const v0, 0x594df2e0

    return v0
.end method
