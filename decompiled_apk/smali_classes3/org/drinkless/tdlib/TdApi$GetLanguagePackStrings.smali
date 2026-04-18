.class public Lorg/drinkless/tdlib/TdApi$GetLanguagePackStrings;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetLanguagePackStrings"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$LanguagePackStrings;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4a486790


# instance fields
.field public keys:[Ljava/lang/String;

.field public languagePackId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26284
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26285
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "strArr"    # [Ljava/lang/String;

    .line 26274
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26275
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetLanguagePackStrings;->languagePackId:Ljava/lang/String;

    .line 26276
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetLanguagePackStrings;->keys:[Ljava/lang/String;

    .line 26277
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26281
    const v0, 0x4a486790    # 3283428.0f

    return v0
.end method
