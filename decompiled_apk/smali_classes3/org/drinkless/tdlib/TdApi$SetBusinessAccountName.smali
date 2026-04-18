.class public Lorg/drinkless/tdlib/TdApi$SetBusinessAccountName;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBusinessAccountName"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3b946b52


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public firstName:Ljava/lang/String;

.field public lastName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40130
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40131
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;

    .line 40119
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40120
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessAccountName;->businessConnectionId:Ljava/lang/String;

    .line 40121
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessAccountName;->firstName:Ljava/lang/String;

    .line 40122
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessAccountName;->lastName:Ljava/lang/String;

    .line 40123
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40127
    const v0, 0x3b946b52

    return v0
.end method
