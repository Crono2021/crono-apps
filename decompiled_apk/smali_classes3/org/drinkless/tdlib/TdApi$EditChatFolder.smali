.class public Lorg/drinkless/tdlib/TdApi$EditChatFolder;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditChatFolder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x332fb32


# instance fields
.field public chatFolderId:I

.field public folder:Lorg/drinkless/tdlib/TdApi$ChatFolder;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25344
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25345
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$ChatFolder;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "chatFolder"    # Lorg/drinkless/tdlib/TdApi$ChatFolder;

    .line 25334
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25335
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$EditChatFolder;->chatFolderId:I

    .line 25336
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$EditChatFolder;->folder:Lorg/drinkless/tdlib/TdApi$ChatFolder;

    .line 25337
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25341
    const v0, 0x332fb32

    return v0
.end method
