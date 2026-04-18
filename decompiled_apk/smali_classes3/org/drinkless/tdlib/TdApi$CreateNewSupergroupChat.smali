.class public Lorg/drinkless/tdlib/TdApi$CreateNewSupergroupChat;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateNewSupergroupChat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Chat;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2fecf6c6


# instance fields
.field public description:Ljava/lang/String;

.field public forImport:Z

.field public isChannel:Z

.field public isForum:Z

.field public location:Lorg/drinkless/tdlib/TdApi$ChatLocation;

.field public messageAutoDeleteTime:I

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51224
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 51225
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZZLjava/lang/String;Lorg/drinkless/tdlib/TdApi$ChatLocation;IZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "chatLocation"    # Lorg/drinkless/tdlib/TdApi$ChatLocation;
    .param p6, "i9"    # I
    .param p7, "z10"    # Z

    .line 51209
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 51210
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CreateNewSupergroupChat;->title:Ljava/lang/String;

    .line 51211
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$CreateNewSupergroupChat;->isForum:Z

    .line 51212
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$CreateNewSupergroupChat;->isChannel:Z

    .line 51213
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$CreateNewSupergroupChat;->description:Ljava/lang/String;

    .line 51214
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$CreateNewSupergroupChat;->location:Lorg/drinkless/tdlib/TdApi$ChatLocation;

    .line 51215
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$CreateNewSupergroupChat;->messageAutoDeleteTime:I

    .line 51216
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$CreateNewSupergroupChat;->forImport:Z

    .line 51217
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51221
    const v0, 0x2fecf6c6

    return v0
.end method
