.class public Lorg/drinkless/tdlib/TdApi$DeleteChatFolder;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteChatFolder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x749bc107


# instance fields
.field public chatFolderId:I

.field public leaveChatIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24984
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24985
    return-void
.end method

.method public constructor <init>(I[J)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "jArr"    # [J

    .line 24974
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24975
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatFolder;->chatFolderId:I

    .line 24976
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatFolder;->leaveChatIds:[J

    .line 24977
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24981
    const v0, -0x749bc107

    return v0
.end method
