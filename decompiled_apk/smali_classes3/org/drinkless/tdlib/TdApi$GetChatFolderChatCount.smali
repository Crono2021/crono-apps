.class public Lorg/drinkless/tdlib/TdApi$GetChatFolderChatCount;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatFolderChatCount"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Count;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7dd4cbbe


# instance fields
.field public folder:Lorg/drinkless/tdlib/TdApi$ChatFolder;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12408
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12409
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatFolder;)V
    .locals 0
    .param p1, "chatFolder"    # Lorg/drinkless/tdlib/TdApi$ChatFolder;

    .line 12399
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12400
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatFolderChatCount;->folder:Lorg/drinkless/tdlib/TdApi$ChatFolder;

    .line 12401
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12405
    const v0, 0x7dd4cbbe

    return v0
.end method
