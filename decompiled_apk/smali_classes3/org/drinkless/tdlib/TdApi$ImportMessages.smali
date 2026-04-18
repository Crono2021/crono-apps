.class public Lorg/drinkless/tdlib/TdApi$ImportMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ImportMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6f1c2a30


# instance fields
.field public attachedFiles:[Lorg/drinkless/tdlib/TdApi$InputFile;

.field public chatId:J

.field public messageFile:Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37776
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37777
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$InputFile;[Lorg/drinkless/tdlib/TdApi$InputFile;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p4, "inputFileArr"    # [Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 37765
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37766
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ImportMessages;->chatId:J

    .line 37767
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ImportMessages;->messageFile:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 37768
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ImportMessages;->attachedFiles:[Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 37769
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37773
    const v0, -0x6f1c2a30

    return v0
.end method
