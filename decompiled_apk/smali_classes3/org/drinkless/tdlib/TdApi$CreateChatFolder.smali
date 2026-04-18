.class public Lorg/drinkless/tdlib/TdApi$CreateChatFolder;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateChatFolder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3c85c500


# instance fields
.field public folder:Lorg/drinkless/tdlib/TdApi$ChatFolder;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11076
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11077
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatFolder;)V
    .locals 0
    .param p1, "chatFolder"    # Lorg/drinkless/tdlib/TdApi$ChatFolder;

    .line 11067
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11068
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CreateChatFolder;->folder:Lorg/drinkless/tdlib/TdApi$ChatFolder;

    .line 11069
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11073
    const v0, 0x3c85c500

    return v0
.end method
