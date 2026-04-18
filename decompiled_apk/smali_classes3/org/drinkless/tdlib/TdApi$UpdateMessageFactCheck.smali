.class public Lorg/drinkless/tdlib/TdApi$UpdateMessageFactCheck;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateMessageFactCheck"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3c78fb02


# instance fields
.field public chatId:J

.field public factCheck:Lorg/drinkless/tdlib/TdApi$FactCheck;

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41714
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41715
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$FactCheck;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "factCheck"    # Lorg/drinkless/tdlib/TdApi$FactCheck;

    .line 41703
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41704
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageFactCheck;->chatId:J

    .line 41705
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageFactCheck;->messageId:J

    .line 41706
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageFactCheck;->factCheck:Lorg/drinkless/tdlib/TdApi$FactCheck;

    .line 41707
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41711
    const v0, 0x3c78fb02

    return v0
.end method
