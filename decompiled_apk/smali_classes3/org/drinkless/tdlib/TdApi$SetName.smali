.class public Lorg/drinkless/tdlib/TdApi$SetName;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetName"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x66065f10


# instance fields
.field public firstName:Ljava/lang/String;

.field public lastName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31628
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31629
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 31618
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31619
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetName;->firstName:Ljava/lang/String;

    .line 31620
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetName;->lastName:Ljava/lang/String;

    .line 31621
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31625
    const v0, 0x66065f10

    return v0
.end method
