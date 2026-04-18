.class public Lorg/drinkless/tdlib/TdApi$UpdateNewBusinessMessage;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateNewBusinessMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7941b9bc


# instance fields
.field public connectionId:Ljava/lang/String;

.field public message:Lorg/drinkless/tdlib/TdApi$BusinessMessage;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34688
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34689
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$BusinessMessage;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "businessMessage"    # Lorg/drinkless/tdlib/TdApi$BusinessMessage;

    .line 34678
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34679
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewBusinessMessage;->connectionId:Ljava/lang/String;

    .line 34680
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewBusinessMessage;->message:Lorg/drinkless/tdlib/TdApi$BusinessMessage;

    .line 34681
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34685
    const v0, -0x7941b9bc

    return v0
.end method
