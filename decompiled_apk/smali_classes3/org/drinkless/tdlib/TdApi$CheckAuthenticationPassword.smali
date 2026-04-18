.class public Lorg/drinkless/tdlib/TdApi$CheckAuthenticationPassword;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CheckAuthenticationPassword"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x78bdb460


# instance fields
.field public password:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10536
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10537
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 10527
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10528
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CheckAuthenticationPassword;->password:Ljava/lang/String;

    .line 10529
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10533
    const v0, -0x78bdb460

    return v0
.end method
