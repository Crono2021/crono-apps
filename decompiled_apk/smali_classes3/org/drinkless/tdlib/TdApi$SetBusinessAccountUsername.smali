.class public Lorg/drinkless/tdlib/TdApi$SetBusinessAccountUsername;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBusinessAccountUsername"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5a9b499f


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31108
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31109
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 31098
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31099
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessAccountUsername;->businessConnectionId:Ljava/lang/String;

    .line 31100
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessAccountUsername;->username:Ljava/lang/String;

    .line 31101
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31105
    const v0, -0x5a9b499f    # -1.983764E-16f

    return v0
.end method
