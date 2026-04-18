.class public Lorg/drinkless/tdlib/TdApi$DeleteAccount;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteAccount"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x533276c6


# instance fields
.field public password:Ljava/lang/String;

.field public reason:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24884
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24885
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 24874
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24875
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteAccount;->reason:Ljava/lang/String;

    .line 24876
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$DeleteAccount;->password:Ljava/lang/String;

    .line 24877
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24881
    const v0, 0x533276c6

    return v0
.end method
